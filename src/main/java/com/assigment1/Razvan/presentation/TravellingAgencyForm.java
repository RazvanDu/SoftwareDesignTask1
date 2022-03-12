package com.assigment1.Razvan.presentation;

import com.assigment1.Razvan.bussiness.DestinationService;
import com.assigment1.Razvan.bussiness.UserService;
import com.assigment1.Razvan.bussiness.VacationsService;
import com.assigment1.Razvan.persistence.DestinationsEntity;
import com.assigment1.Razvan.persistence.UserEntity;
import com.assigment1.Razvan.persistence.VacationpackageEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravellingAgencyForm {
    private JPanel mainPanel;
    private JTable packagesTable;
    private JScrollPane panel;
    private JTextField vacationID;
    private JButton chooseButton;
    private JTable chosenVacation;
    private JButton updateButton;
    private JFrame frame;
    private VacationsService vacationsService;
    private UserService userService;
    private DestinationService destinationService;

    public TravellingAgencyForm(UserService userService, VacationsService vacationsService, DestinationService destinationService) {
        this.vacationsService = vacationsService;
        this.userService = userService;
        this.destinationService = destinationService;
        frame = new JFrame("Agency");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 400);
        updateTable(vacationsService.byDestination(""));
        chooseButton.addActionListener(e -> {
            int id;
            try {
                id = Integer.parseInt(vacationID.getText());
            } catch(Exception exp) {
                JOptionPane.showMessageDialog(frame, "Invalid destination!");
                return;
            }
            if(id < 0) {
                JOptionPane.showMessageDialog(frame, "Invalid destination!");
                return;
            }
            VacationpackageEntity vacation = vacationsService.byID(id);
            if(vacation == null) {
                JOptionPane.showMessageDialog(frame, "Invalid destination!");
                return;
            }
            if(vacation.getSlotsAvailable() == 0) {
                JOptionPane.showMessageDialog(frame, "The destination is already fully booked!");
                return;
            }
            updateChosen(vacation);
        });
        updateButton.addActionListener(e -> {
            int id;
            try {
                id = Integer.parseInt(vacationID.getText());
            } catch(Exception exp) {
                JOptionPane.showMessageDialog(frame, "Invalid destination!");
                return;
            }
            if(id < 0) {
                JOptionPane.showMessageDialog(frame, "Invalid destination!");
                return;
            }
            VacationpackageEntity vacation = vacationsService.byID(id);
            vacation.setName((String) chosenVacation.getValueAt(0, 1));
            vacation.setPrice(Integer.parseInt((String) chosenVacation.getValueAt(0, 2)));
            try {
                vacation.setStartDate(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse((String) chosenVacation.getValueAt(0, 3)).getTime()));
                vacation.setEndDate(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse((String) chosenVacation.getValueAt(0, 4)).getTime()));
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            int slotsTotal = (Integer) chosenVacation.getValueAt(0, 5);
            int slotsLeft = (Integer) chosenVacation.getValueAt(0, 6);
            if(slotsTotal < 0 || slotsLeft < 0 || slotsLeft > slotsTotal) {
                JOptionPane.showMessageDialog(frame, "Invalid number of slots!");
                return;
            }
            vacation.setSlotsAvailable(slotsLeft);
            vacation.setTotalSlots(slotsTotal);
            DestinationsEntity destinationsEntity = destinationService.findByName((String) chosenVacation.getValueAt(0, 7));
            if(destinationsEntity == null) {
                JOptionPane.showMessageDialog(frame, "Not a valid destionation!");
                return;
            }
            vacation.setDestination(destinationsEntity);
            vacation.setExtraDetails((String) chosenVacation.getValueAt(0, 8));
            vacationsService.save(vacation);
            updateTable(vacationsService.byDestination(""));
            JOptionPane.showMessageDialog(frame, "Successfully updated the vacation!");
        });
    }

    public void updateChosen(VacationpackageEntity vacationpackageEntity) {

        updateGeneric(Arrays.asList(vacationpackageEntity), chosenVacation);

    }

    public void updateTable(List<VacationpackageEntity> vacationpackageEntities) {

        updateGeneric(vacationpackageEntities, packagesTable);

    }

    private void updateGeneric(List<VacationpackageEntity> vacations, JTable bookedTable) {

        if(vacations == null)
            vacations = new ArrayList<>();

        DefaultTableModel model = (DefaultTableModel) bookedTable.getModel();

        model.setColumnCount(0);
        model.setRowCount(0);

        model.setColumnIdentifiers(Arrays.asList("Id", "Name", "Price", "Start Date", "End Date", "Slots Total", "Slots Left", "Destination", "Details").toArray());
        for(VacationpackageEntity vacationpackageEntity : vacations) {
            model.addRow(Arrays.asList(vacationpackageEntity.getId(), vacationpackageEntity.getName(), vacationpackageEntity.getPrice(),
                    vacationpackageEntity.getStartDate().toString(), vacationpackageEntity.getEndDate().toString(), vacationpackageEntity.getTotalSlots(),
                    vacationpackageEntity.getSlotsAvailable(), vacationpackageEntity.getDestination().getName(), vacationpackageEntity.getExtraDetails()).toArray());
        }

    }

}
