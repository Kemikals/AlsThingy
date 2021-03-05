package com.store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.helpers.Fonts;
import com.parts.Cpu;
import com.parts.Disk;
import com.parts.Ram;

@SuppressWarnings({"serial", "rawtypes"})
public class ComponentsBoard extends JPanel implements ActionListener{

	public final JComboBox ramCombo;
	public final JComboBox cpuCombo;
	public final JComboBox diskCombo;
	public final JComboBox osCombo;
	public final Ram ram = new Ram("0 GB", "RAM");
	public final Cpu cpu = new Cpu("0 GHz", "CPU");
	public final Disk disk = new Disk("0 GB", "STORAGE");

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ComponentsBoard(){
		setLayout(null);
		setBounds(10, 98, 784, 274);


		ramCombo = new JComboBox(new String[] {"0 GB", "8 GB", "16 GB", "32 GB"});
		ramCombo.setFont(Fonts.Bold_Size(30));
		ramCombo.setBounds(498, 11, 141, 56);
		ramCombo.addActionListener(this);
		add(ramCombo);

		cpuCombo = new JComboBox(new String[] {"0 GHz", "2 GHz", "3 GHz", "4 GHz"});
		cpuCombo.setFont(Fonts.Bold_Size(30));
		cpuCombo.setBounds(498, 78, 141, 56);
		cpuCombo.addActionListener(this);
		add(cpuCombo);

		diskCombo = new JComboBox(new String[] {"0 GB", "120 GB", "250 GB", "512 GB"});
		diskCombo.setFont(Fonts.Bold_Size(30));
		diskCombo.setBounds(498, 145, 141, 56);
		diskCombo.addActionListener(this);
		add(diskCombo);

		osCombo = new JComboBox(new String[] {"DOS", "WINDOWS", "MAC", "LINUX"});
		osCombo.setFont(Fonts.Bold_Size(30));
		osCombo.setBounds(498, 212, 230, 56);
		osCombo.addActionListener(this);
		add(osCombo);

		JLabel ramLabel = new JLabel("SELECT MEMORY SIZE ( RAM ) :");
		ramLabel.setFont(Fonts.Plain_Size(30));
		ramLabel.setBounds(10, 11, 478, 56);
		add(ramLabel);

		JLabel cpuLabel = new JLabel("SELECT CPU (PROCESSOR) :");
		cpuLabel.setFont(Fonts.Plain_Size(30));
		cpuLabel.setBounds(10, 78, 478, 56);
		add(cpuLabel);

		JLabel diskLabel = new JLabel("SELECT YOUR STORAGE SIZE :");
		diskLabel.setFont(Fonts.Plain_Size(30));
		diskLabel.setBounds(10, 145, 478, 56);
		add(diskLabel);

		JLabel osLabel = new JLabel("OPERATING SYSTEM TO INSTALL :");
		osLabel.setFont(Fonts.Plain_Size(30));
		osLabel.setBounds(10, 212, 478, 56);
		add(osLabel);



	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==cpuCombo) 
		{
			cpu.setSpeed(Objects.requireNonNull(cpuCombo.getSelectedItem()).toString());
			System.out.println(cpuCombo.getSelectedItem());
		}
		if(e.getSource()==ramCombo) 
		{
			ram.setSize(Objects.requireNonNull(ramCombo.getSelectedItem()).toString());
			System.out.println(ramCombo.getSelectedItem());
		}
		if(e.getSource()==diskCombo) 
		{
			disk.setCapacity(Objects.requireNonNull(diskCombo.getSelectedItem()).toString());
			System.out.println(diskCombo.getSelectedItem());
		}
		if(e.getSource()==osCombo) 
		{
			System.out.println(osCombo.getSelectedItem());
		}


	}



}
