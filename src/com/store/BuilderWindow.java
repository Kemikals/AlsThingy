package com.store;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import com.helpers.Fonts;
import com.components.Component;

public class BuilderWindow extends JFrame {

    private static int COUNT;
    private final JButton buildButton;
    private final JProgressBar progressBar;
    private Timer timer;
    public final JTextArea view;
    public static final ArrayList<Component> COMPONENTS = new ArrayList<>();
    protected final ComponentsBoard componentsBoard = new ComponentsBoard();

    BuilderWindow() {

        setBounds(100, 100, 815, 645);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(null);

        JLabel storeLabel = new JLabel("COMPUTER STORE ");
        storeLabel.setFont(Fonts.ItalicBold_Size(30));
        storeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        storeLabel.setBounds(10, 11, 784, 38);
        container.add(storeLabel);

        JLabel letsBuildLabel = new JLabel("LETS BUILD YOUR COMPUTER");
        letsBuildLabel.setForeground(Color.BLUE);
        letsBuildLabel.setFont(Fonts.ItalicBold_Size(30));
        letsBuildLabel.setHorizontalAlignment(SwingConstants.CENTER);
        letsBuildLabel.setBounds(10, 49, 784, 38);
        container.add(letsBuildLabel);

        buildButton = new JButton("BUILD AND PRINT MY ORDER");
        buildButton.addActionListener((e) -> startBuild());
        buildButton.setFont(Fonts.Bold_Size(20));
        buildButton.setBounds(226, 375, 336, 38);
        container.add(buildButton);

        view = new JTextArea();
        view.setFont(Fonts.Bold_Size(20));
        view.setBounds(10, 449, 784, 151);
        container.add(view);

        progressBar = new JProgressBar();
        progressBar.setBounds(10, 416, 784, 27);
        container.add(progressBar);

        timer = new Timer(50, (timerEvent) -> {

            progressBar.setValue(
                    COUNT++);

            if (progressBar.getValue() == 5) {
                view.append(componentsBoard.getRam().install().getInstallMessage().toString());
                view.append(System.lineSeparator());
                COMPONENTS.add(componentsBoard.getRam());
            }

            if (progressBar.getValue() == 30) {
                view.append(componentsBoard.getCpu().install().getInstallMessage().toString());
                view.append(System.lineSeparator());
                COMPONENTS.add(componentsBoard.getCpu());
            }
            if (progressBar.getValue() == 50) {
                view.append(componentsBoard.getDisk().install().getInstallMessage().toString());
                view.append(System.lineSeparator());
                COMPONENTS.add(componentsBoard.getDisk());
            }
            if (progressBar.getValue() == 75) {
                if (!componentsBoard.getOs().isInstallableOnBoard(componentsBoard)) {
                    view.append(componentsBoard.getOs().getFailureMessage().toString());
                    view.append(System.lineSeparator());
                    timer.stop();
                    JOptionPane.showMessageDialog(this, "UNABLE TO FINISH BUILDING YOU PC , PLEASE MAKE SURE THAT YOU SELECTED EACH OF : RAM SIZE , CPU SPEED , DISK CAPACITY");
                    reset();

                }

            }
            if (progressBar.getValue() == 80) {
                view.append(componentsBoard.os.install().getInstallMessage().toString());
            }

            if (progressBar.getValue() == 100) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "CONGRATS , YOUR COMPUTER IS ALL SET  ");
                componentsBoard.ram.print();
                componentsBoard.cpu.print();
                componentsBoard.disk.print();

            }
        });

        getContentPane().add(componentsBoard);
    }

    private void reset() {
        timer.stop();
        view.setText("");
        COMPONENTS.clear();
        COUNT = 0;
        progressBar.setValue(COUNT);
        buildButton.setEnabled(true);
        componentsBoard.cpuCombo.setEnabled(true);
        componentsBoard.ramCombo.setEnabled(true);
        componentsBoard.diskCombo.setEnabled(true);
        componentsBoard.osCombo.setEnabled(true);
        componentsBoard.ram.setSize("0 GB");
        componentsBoard.cpu.setSpeed("0 GHz");
        componentsBoard.disk.setCapacity("0 GB");
    }

    private void startBuild() {
        timer.start();
        buildButton.setEnabled(false);
        componentsBoard.cpuCombo.setEnabled(false);
        componentsBoard.ramCombo.setEnabled(false);
        componentsBoard.diskCombo.setEnabled(false);
        componentsBoard.osCombo.setEnabled(false);
    }

}
