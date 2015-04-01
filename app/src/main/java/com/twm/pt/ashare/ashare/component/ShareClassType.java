package com.twm.pt.ashare.ashare.component;

/**
 * Created by TangWen on 2015/3/25.
 */
public enum ShareClassType {

    /** 工具 */
    TOOLS(0),
    /** 安全 */
    SAFE(1),
    /** 介面 */
    UI(2),
    /** 效能 */
    PERFORMANCE(3);

    int value;

    ShareClassType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ShareClassType lookup(final int value) {
        ShareClassType type = null;
        for (ShareClassType type1 : ShareClassType.values()) {
            if (value == type1.getValue() ) {
                type = type1;
                break;
            }
        }
        return type;
    }

    public static ShareClassType lookup(final String valueString) {
        try {
            int value = Integer.parseInt(valueString);
            return lookup(value);
        } catch (Exception e) {
            ShareClassType type = null;
            if(valueString!=null) {
                for (ShareClassType type1 : ShareClassType.values()) {
                    if (type1.toString().equalsIgnoreCase(valueString) ) {
                        type = type1;
                        break;
                    }
                }
            }
            return type;
        }
    }
}
