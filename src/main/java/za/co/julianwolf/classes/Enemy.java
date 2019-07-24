package za.co.julianwolf.classes;

import za.co.julianwolf.interfaces.IEntity;
import za.co.julianwolf.logger.MyLogger;

import java.util.Random;

import com.mongodb.internal.connection.Time;

import za.co.julianwolf.abstractclasses.AbstractEntity;
import za.co.julianwolf.enums.eClass;
import za.co.julianwolf.enums.eState;

public class Enemy extends AbstractEntity implements IEntity{

	private double reqexp;
	Random R = new Random(Time.nanoTime());

	public Enemy(String name, eClass c, eState state)
	{
		this.Name = name;
		this.Class = c;
		this.state = state;
		this.Level = R.nextInt(20);
		this.Attack = R.nextInt(100);
		this.Defence = R.nextInt(100);
		this.Health = R.nextInt(10) * (10 + 1);
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
