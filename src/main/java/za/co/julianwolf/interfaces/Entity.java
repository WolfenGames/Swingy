package za.co.julianwolf.interfaces;

import za.co.julianwolf.enums.ClassEnum;

public interface Entity {
    String      Name = "";
    ClassEnum   Class = ClassEnum.NONE;
    State       state = State.NONE;
    int         Level = 0;
    double      Exp = 0;
    int         Attack = 0;
    int         Defence = 0;
    double      Health = 0;
}
