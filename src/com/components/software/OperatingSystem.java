package com.components.software;

import com.components.Component;
import com.components.InstallMessage;
import com.store.ComponentsBoard;

public class OperatingSystem extends Component {
    private String osName;
    private InstallMessage failureMessage;

    public OperatingSystem(String name, String osName) {
        super(name, InstallMessage.OS);
        this.failureMessage = InstallMessage.OS_FAILURE;
        this.osName = osName;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public InstallMessage getFailureMessage() {
        return failureMessage;
    }

    public boolean isInstallableOnBoard(ComponentsBoard board) {
        return board.getDisk().isInstalled() && board.getRam().isInstalled() && board.getCpu().isInstalled();
    }
}
