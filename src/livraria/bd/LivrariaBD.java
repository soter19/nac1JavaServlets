package livraria.bd;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import livraria.Config;

/**
 * Forged by Soter Padua on 12/04/17.
 */
public class LivrariaBD {
	private static LivrariaBD    instancia;
	private        MongoDatabase bd;
	private        MongoClient   mongoClient;

	public static LivrariaBD getInstancia(){
		if(instancia == null){
			instancia = new LivrariaBD();
			instancia.conectar();
			return instancia;
		}
		return instancia;
	}

	private void conectar(){
		mongoClient = new MongoClient(Config.MONGO_HOST);
		bd = mongoClient.getDatabase(Config.MONGO_DB_NAME);
	}

	public MongoDatabase getBD() {
		if (mongoClient == null || bd == null) {
			conectar();
		}
		return bd;
	}
}
