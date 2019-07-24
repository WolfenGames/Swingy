package za.co.julianwolf.database;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.ConnectionString;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;

public class mongodatabase{

	private String 	Username;
	private String 	Password;
	private String 	Url;
	private String dbName;
	MongoCollection<Document> collection;

	private MongoClient		client;
	private MongoDatabase	db;

	public mongodatabase(String url, String dbName, String Username, String Password)
	{
		this.Url = url;
		this.Username = Username;
		this.Password = Password;
		this.dbName = dbName;
	}

	public Boolean connect()
	{
		try {
			client = MongoClients.create(new ConnectionString(this.Url));
			db = client.getDatabase(this.dbName);
			collection = db.getCollection("Swingy");
			return (true);
		} catch (Exception e) {
			return false;
		}
	}

}
