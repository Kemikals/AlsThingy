package com.components.software;

import com.components.Component;
import com.components.InstallMessage;
import com.components.MotherBoard;

public class OperatingSystem extends Component {
    private String osName;

    public OperatingSystem(String osName) {
        super("OS");
        this.osName = osName;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }


    public boolean isInstallableOnBoard(MotherBoard board) {
        return board.getDisk().isInstalled() && board.getRam().isInstalled() && board.getCpu().isInstalled();
    }

    @Override
    public String toString() {
        return osName;
    }
}
