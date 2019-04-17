package cn.bithumb.pro.api.model;

import java.util.List;

public class Cmd {
    private String cmd;
    private List<?> args;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public List<?> getArgs() {
        return args;
    }

    public void setArgs(List<?> args) {
        this.args = args;
    }
}
