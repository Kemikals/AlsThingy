package com.components;

import com.components.software.OperatingSystem;
import com.components.hardware.Cpu;
import com.components.hardware.Disk;
import com.components.hardware.Ram;

public class MotherBoard {


    public Ram ram;
    public Cpu cpu;
    public Disk disk;
    public OperatingSystem os;

    public MotherBoard() {
    }

    public Ram getRam() {
        return ram;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public Disk getDisk() {
        return disk;
    }

    public OperatingSystem getOs() {
        return os;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public void setOs(OperatingSystem os) {
        this.os = os;
    }

    public boolean ramInstalled() {
        return ram != null;
    }

    public boolean diskInstalled() {
        return disk != null;
    }

    public boolean cpuInstalled() {
        return cpu != null;
    }
}
