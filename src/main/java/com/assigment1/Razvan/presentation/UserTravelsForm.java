package com.assigment1.Razvan.presentation;

import com.assigment1.Razvan.bussiness.VacationsService;
import com.assigment1.Razvan.persistence.VacationpackageEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class UserTravelsForm {
    private JPanel mainPanel;
    private JTable travelsTable;
    private JComboBox filterChooser;
    private JTextField filterValue;
    private JButton filterButton;

    private JFrame frame;

    private VacationsService vacationsService;

    public UserTravelsForm(VacationsService vacationsService) {
        this.vacationsService = vacationsService;
        frame = new JFrame("Travels");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 400);
        updateTable(vacationsService.getAll());
        filterButton.addActionListener(e -> {
            //System.out.println(((String)filterChooser.getSelectedItem()) + " + " + filterValue.getText());
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
    }

    public void updateTable(List<VacationpackageEntity> vacations) {

        DefaultTableModel model = (DefaultTableModel) travelsTable.getModel();

        model.setColumnCount(0);
        model.setRowCount(0);

        model.setColumnIdentifiers(Arrays.asList("Id", "Name", "Price", "Start Date", "End Date", "Slots Left", "Destination", "Details").toArray());
        for(VacationpackageEntity vacationpackageEntity : vacations) {
            model.addRow(Arrays.asList(vacationpackageEntity.getId(), vacationpackageEntity.getName(), vacationpackageEntity.getPrice(),
                    vacationpackageEntity.getStartDate().toString(), vacationpackageEntity.getEndDate().toString(), vacationpackageEntity.getSlotsAvailable(),
                    vacationpackageEntity.getDestination(), vacationpackageEntity.getExtraDetails()).toArray());
        }

    }

}
