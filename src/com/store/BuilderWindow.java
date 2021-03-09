package com.store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.*;

import com.components.InstallMessage;
import com.components.MotherBoard;
import com.components.hardware.Cpu;
import com.components.hardware.Disk;
import com.components.hardware.Ram;
import com.components.software.OperatingSystem;
import com.helpers.Fonts;
import com.components.Component;

public class BuilderWindow {

    private static int COUNT;
    private final JProgressBar progressBar;
    private final JFrame frame;
    private Timer timer;
    public JTextArea view;
    protected final MotherBoard board;

    public JComboBox<Ram> ramCombo;
    public JComboBox<Cpu> cpuCombo;
    public JComboBox<Disk> diskCombo;
    public JComboBox<OperatingSystem> osCombo;

    private List<JComponent> selections;
    private JButton buildButton;
    private JButton printButton;

    BuilderWindow(int width, int height, MotherBoard board) {
        this.board = board;
        frame = new JFrame();
        JPanel container = new JPanel();
        frame.setSize(width, height);
        frame.add(container);

        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.add(createTitle());
        container.add(createTopSelectionPanel());

        container.add(Box.createRigidArea(new Dimension(0, 20)));
        container.add(createButtons());
        container.add(Box.createRigidArea(new Dimension(0, 20)));
        progressBar = new JProgressBar();
        container.add(progressBar);
        view = new JTextArea();
        view.setFont(Fonts.Bold_Size(20));
        container.add(view);
        selections = List.of(ramCombo, cpuCombo, diskCombo, osCombo, buildButton);

        frame.setVisible(true);
    }

    public JPanel createTopSelectionPanel() {
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(4, 2));

        ramCombo = new JComboBox<>(new Ram[]{new Ram("8 GB"), new Ram("16 GB"), new Ram("32 GB")});
        ramCombo.addActionListener((e) -> board.setRam(ramCombo.getItemAt(ramCombo.getSelectedIndex())));
        createSelection(container, ramCombo, "SELECT MEMORY SIZE ( RAM ) : ");

        cpuCombo = new JComboBox<>(new Cpu[]{new Cpu("2 GHz"), new Cpu("3 GHz"), new Cpu("4 GHz")});
        cpuCombo.addActionListener((e) -> board.setCpu(cpuCombo.getItemAt(cpuCombo.getSelectedIndex())));
        createSelection(container, cpuCombo, "SELECT CPU (PROCESSOR):  ");

        diskCombo = new JComboBox<>(new Disk[]{new Disk("120 GB"), new Disk("250 GB"), new Disk("512 GB")});
        diskCombo.addActionListener((e) -> board.setDisk(diskCombo.getItemAt(diskCombo.getSelectedIndex())));
        createSelection(container, diskCombo, "SELECT YOUR STORAGE SIZE : ");

        osCombo = new JComboBox<>(new OperatingSystem[]{new OperatingSystem("DOS"), new OperatingSystem("WINDOWS"), new OperatingSystem("MAC"), new OperatingSystem("LINUX")});
        osCombo.addActionListener((e) -> board.setOs(osCombo.getItemAt(osCombo.getSelectedIndex())));
        createSelection(container, osCombo, "OPERATING SYSTEM TO INSTALL : ");

        return container;
    }

    public JPanel createTitle() {
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        box.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        box.add(createLabel("         COMPUTER STORE"));
        box.add(createLabel("LETS BUILD YOUR COMPUTER"));
        return box;
    }

    public void createSelection(JPanel container, JComboBox<?> combo, String label) {
        combo.setSelectedIndex(-1);
        container.add(createLabel(label));
        container.add(combo);
    }

    private void reset() {
        timer.stop();
        view.setText("");
        progressBar.setValue(COUNT);
    }

    public JLabel createLabel(String name) {
        JLabel label = new JLabel(name);
        label.setFont(Fonts.Plain_Size(20));
        return label;
    }

    public Box createButtons() {
        Box box = new Box(BoxLayout.X_AXIS);
        printButton = new JButton("PRINT ORDER SHEET");
        printButton.setFont(Fonts.Bold_Size(12));
        buildButton = new JButton("ORDER AND BUILD");
        buildButton.addActionListener(this::build);
        buildButton.setFont(Fonts.Bold_Size(12));
        box.add(printButton);
        box.add(Box.createRigidArea(new Dimension(100, 0)));
        box.add(buildButton);
        return box;
    }

    public void build(ActionEvent a) {
        selections.forEach(selection -> selection.setEnabled(false));
        timer = new Timer(35, (e) -> {


            if (progressBar.getValue() == 5) {
                handleProgressUpdate(board.getRam(), InstallMessage.RAM, InstallMessage.RAM_FAILURE);
            } else if (progressBar.getValue() == 30) {
                handleProgressUpdate(board.getDisk(), InstallMessage.DISK, InstallMessage.DISK_FAILURE);
            } else if (progressBar.getValue() == 50) {
                handleProgressUpdate(board.getCpu(), InstallMessage.CPU, InstallMessage.CPU_FAILURE);
            } else if (progressBar.getValue() == 75 && board.getOs() != null) {
                boolean canInstall = board.getOs().isInstallableOnBoard(board);
                if (canInstall) {
                    handleProgressUpdate(board.getOs(), InstallMessage.OS, InstallMessage.OS_FAILURE);
                } else {
                    addMessage(InstallMessage.OS_FAILURE.toString());
                }
            } else if (progressBar.getValue() == 100) {
                timer.stop();
                JOptionPane.showMessageDialog(frame, "CONGRATS ORDER IS COMPLETED AND YOUR COMPUTER IS ALL SET  ");
            }
            progressBar.setValue(COUNT++);
        });
        timer.addActionListener((e) -> {
            if (!timer.) {
                selections.forEach(selection -> selection.setEnabled(true));
            }
        });
        timer.start();
    }

    public void addMessage(String message) {
        view.append(message + System.lineSeparator());
    }

    private void handleProgressUpdate(Component component, InstallMessage success, InstallMessage failure) {
        addMessage((component != null ? success : failure).toString());
        if (component != null) {
            component.install();
        } else {
            timer.stop();
        }
    }
}