package za.co.julianwolf.abstractclasses;

import za.co.julianwolf.enums.eClass;
import za.co.julianwolf.enums.eState;

public abstract class AbstractEntity {
	public String		Name;// = "";
    public eClass		Class;// = eClass.NONE;
    public eState		state;// = eState.NONE;
    public int			Level;// = 0;
    public double		Exp; //= 0;
    public int			Attack; //= 0;
    public int			Defence; //= 0;
    public double		Health; //= 0;
}
