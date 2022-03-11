package com.assigment1.Razvan.presentation;

import com.assigment1.Razvan.bussiness.UserService;
import com.assigment1.Razvan.bussiness.VacationsService;
import com.assigment1.Razvan.persistence.VacationpackageEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserTravelsForm {
    private JPanel mainPanel;
    private JTable travelsTable;
    private JComboBox filterChooser;
    private JTextField filterValue;
    private JButton filterButton;
    private JButton orderButton;
    private JTextField vacationID;
    private JTable bookedTable;

    private JFrame frame;

    private VacationsService vacationsService;
    private UserService userService;

    public UserTravelsForm(UserService userService, VacationsService vacationsService) {
        this.vacationsService = vacationsService;
        this.userService = userService;
        frame = new JFrame("Travels");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 400);
        updateTable(vacationsService.byDestination(""));
        updateBooked();
        filterButton.addActionListener(e -> {
            int val;
            switch(((String)filterChooser.getSelectedItem())) {
                case "Destination":
                    updateTable(vacationsService.byDestination(filterValue.getText()));
                    break;
                case "Price":
                    try {
                        val = Integer.parseInt(filterValue.getText());
                    }  catch(Exception exc) {
                        val = 100000000;
                    }
                    if(val < 0)
                        val = 100000000;
                    updateTable(vacationsService.byPrice(val));
                    break;
                case "Period":
                    try {
                        val = Integer.parseInt(filterValue.getText());
                    }  catch(Exception exc) {
                        val = 100000000;
                    }
                    if(val < 0)
                        val = 100000000;
                    updateTable(vacationsService.byPeriod(val));
                    break;
            }
        });
        orderButton.addActionListener(e -> {
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
            userService.getLoggedUser().getPackages().add(vacation);
            vacation.setSlotsAvailable(vacation.getSlotsAvailable() - 1);
            userService.save(userService.getLoggedUser());
            vacationsService.save(vacation);
            updateTable(vacationsService.byDestination(""));
            updateBooked();
        });
    }

    public void updateTable(List<VacationpackageEntity> vacations) {

        updateGeneric(vacations, travelsTable);

    }

    public void updateBooked() {

        updateGeneric(userService.getLoggedUser().getPackages(), bookedTable);

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
