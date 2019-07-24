package za.co.julianwolf.interfaces;

public interface IEntity {
	void	takeDamage(float val);
	void	heal(float val);
	void	gainexp(float val);
	boolean	amIAlive();
	boolean amIDead();
	void	attack(IEntity body);
	void	defend(IEntity body);
	void	levelUp();
}
