package za.co.julianwolf.classes;

import za.co.julianwolf.interfaces.IEntity;
import za.co.julianwolf.logger.MyLogger;
import za.co.julianwolf.abstractclasses.AbstractEntity;
import za.co.julianwolf.enums.eClass;
import za.co.julianwolf.enums.eState;

public class Hero extends AbstractEntity implements IEntity{

	private double reqexp;

	public Hero(String name, double startExp, eClass c, eState state, int Attack, int Defence, double Health)
	{
		this.Name = name;
		this.Exp = startExp;
		this.Class = c;
		this.state = state;
		this.Level = 1;
		this.Attack = Attack;
		this.Defence = Defence;
		this.Health = Health;
		reqexp = calcexp();
	}

	private double calcexp()
	{
		return (this.Level * 1000  + Math.pow((this.Level - 1), 2) * 450);
	}

	public void takeDamage(float val) {
		if (amIAlive())
			this.Health -= val;
		if (amIDead())
			MyLogger.logger.log(this.Name + " Is Dead");
	}

	public void heal(float val) {
		this.Health += val;
	}

	public void gainexp(float val) {
		this.Exp += val;
		while (this.Exp > reqexp)
		{
			MyLogger.logger.log(Double.toString(this.Exp) + ">::>" + Double.toString(this.reqexp));
			levelUp();
		}
	}

	public boolean amIAlive() {
		return (this.Health > 0);
	}

	public boolean amIDead() {
		return (!amIAlive());
	}

	public void attack(IEntity body) {

	}

	public void defend(IEntity body) {

	}

	public void levelUp() {
		this.Level++;
		reqexp = calcexp();
	}
}
