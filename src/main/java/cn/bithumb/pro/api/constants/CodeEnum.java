package cn.bithumb.pro.api.constants;

public enum CodeEnum {

    CONNECTED("00002"),
    INIT_MSG("00006"),
    NORMAL_MSG("00007"),
    ;

    CodeEnum(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }

}
