package com.store;

import com.components.Component;
import com.components.MotherBoard;
import com.components.hardware.Cpu;
import com.components.hardware.Disk;
import com.components.hardware.Ram;
import com.components.software.OperatingSystem;
import com.helpers.Fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class BuilderWindow {

    private final JFrame frame;
    private final JProgressBar progressBar;
    private final List<JComponent> selections;
    private final JTextArea view;

    private JComboBox<Ram> ramCombo;
    private JComboBox<Cpu> cpuCombo;
    private JComboBox<Disk> diskCombo;
    private JComboBox<OperatingSystem> osCombo;

    private Timer timer;
    private JButton buildButton;

    private static final int TIMER_DELAY = 35;
    private static final int MIN_WIDTH = 820;
    private static final int MIN_HEIGHT = 500;

    private final MotherBoard board;

    public BuilderWindow(MotherBoard board) {
        this.board = board;
        frame = new JFrame();
        progressBar = new JProgressBar();
        view = new JTextArea();
        addAndStyleComponents(frame, progressBar, view);

        selections = List.of(ramCombo, cpuCombo, diskCombo, osCombo, buildButton);
    }

    private void addAndStyleComponents(JFrame frame, JProgressBar progressBar, JTextArea view) {
        JPanel container = new JPanel();
        frame.setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        frame.add(container);
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.add(createTitle());
        container.add(createTopSelectionPanel());
        container.add(progressBar);
        container.add(view);
        container.add(Box.createRigidArea(new Dimension(0, 20)));
        container.add(createButtons());
        container.add(Box.createRigidArea(new Dimension(0, 20)));
        view.setFont(Fonts.Bold_Size(20));
        frame.setVisible(true);
    }

    private JPanel createTitle() {
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        box.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        box.add(createLabel("         COMPUTER STORE"));
        box.add(createLabel("LETS BUILD YOUR COMPUTER"));
        return box;
    }

    private JLabel createLabel(String name) {
        JLabel label = new JLabel(name);
        label.setFont(Fonts.Plain_Size(20));
        return label;
    }

    private JPanel createTopSelectionPanel() {
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

    private void createSelection(JPanel container, JComboBox<?> combo, String label) {
        combo.setSelectedIndex(-1);
        container.add(createLabel(label));
        container.add(combo);
    }

    private Box createButtons() {
        Box box = new Box(BoxLayout.X_AXIS);
        JButton printButton = new JButton("PRINT ORDER SHEET");
        printButton.setFont(Fonts.Bold_Size(12));
        buildButton = new JButton("ORDER AND BUILD");
        buildButton.addActionListener(this::build);
        buildButton.setFont(Fonts.Bold_Size(12));
        box.add(printButton);
        box.add(Box.createRigidArea(new Dimension(100, 0)));
        box.add(buildButton);
        return box;
    }

    private void build(ActionEvent a) {
        setSelectionsEnabled(false);
        view.setText("");
        progressBar.setValue(0);
        timer = new Timer(TIMER_DELAY, (e) -> {
            handleProgressUpdate(board, progressBar.getValue());
            updateProgressBar();
        });
        timer.start();
    }

    private void handleProgressUpdate(MotherBoard board, int progressBarPercent) {
        if (progressBarPercent == 5) {
            handleInstallComponent(board.getRam(), InstallMessage.RAM, InstallMessage.RAM_FAILURE);
        } else if (progressBarPercent == 30) {
            handleInstallComponent(board.getDisk(), InstallMessage.DISK, InstallMessage.DISK_FAILURE);
        } else if (progressBarPercent == 50) {
            handleInstallComponent(board.getCpu(), InstallMessage.CPU, InstallMessage.CPU_FAILURE);
        } else if (progressBarPercent == 75) {
            handleOsInstall();
        } else if (progressBarPercent == 100) {
            handleBuildComplete();
        }
    }

    private void handleInstallComponent(Component component, InstallMessage success, InstallMessage failure) {
        addMessage((component != null ? success : failure).toString());
        if (component != null) {
            component.install();
        } else {
            timer.stop();
            setSelectionsEnabled(true);
        }
    }

    private void handleOsInstall() {
        if (board.getOs() != null && board.getOs().isInstallableOnBoard(board)) {
            handleInstallComponent(board.getOs(), InstallMessage.OS, InstallMessage.OS_FAILURE);
        } else {
            addMessage(InstallMessage.OS_FAILURE.toString());
            setSelectionsEnabled(true);
            timer.stop();
        }
    }

    private void handleBuildComplete() {
        timer.stop();
        JOptionPane.showMessageDialog(frame, "CONGRATS ORDER IS COMPLETED AND YOUR COMPUTER IS ALL SET  ");
    }

    private void updateProgressBar() {
        progressBar.setValue(progressBar.getValue() + 1);
    }

    private void addMessage(String message) {
        view.append(message + System.lineSeparator());
    }

    private void setSelectionsEnabled(boolean value) {
        selections.forEach(selection -> selection.setEnabled(value));
    }
}