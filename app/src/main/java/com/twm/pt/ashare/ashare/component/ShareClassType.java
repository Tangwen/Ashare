package com.twm.pt.ashare.ashare.component;

/**
 * Created by TangWen on 2015/3/25.
 */
public enum ShareClassType {

    /** 全部 */
    ALL("全部 "),
    /** 工具 */
    TOOLS("工具 "),
    /** 安全 */
    SAFE("安全"),
    /** 介面 */
    UI("介面"),
    /** 效能 */
    PERFORMANCE("效能 "),
    /** 功能 */
    FUNCTIONS("功能 "),
    ;

    String value;

    ShareClassType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    public static ShareClassType lookup(final String valueString) {
        ShareClassType type = null;
        if (valueString != null) {
            for (ShareClassType type1 : ShareClassType.values()) {
                if (type1.getValue().equalsIgnoreCase(valueString)) {
                    type = type1;
                    break;
                }
            }
        }
        return type;
    }

    public static String[] names() {
        ShareClassType[] data = values();
        String[] names = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            names[i] = data[i].name();
        }

        return names;
    }

    public static String[] getStringNames() {
        ShareClassType[] data = values();
        String[] names = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            names[i] = data[i].getValue();
        }

        return names;
    }
}
