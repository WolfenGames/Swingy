package za.co.julianwolf.classes;

import java.util.ArrayList;
import java.util.List;

import za.co.julianwolf.interfaces.IEntity;

public final class GameManager {
	public static GameManager instance;

	public List<IEntity>objects = new ArrayList<IEntity>();

	GameManager()
	{
		if (instance == null)
			instance = new GameManager();
	}
}
