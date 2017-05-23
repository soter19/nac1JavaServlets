package livraria;

/**
 * Forged by Soter Padua on 12/04/17.
 */
public class Helper {
	public final static String idFieldName = "_id";

	public static Boolean isNullOrEmptyString(String s){
		return s == null || s.trim().isEmpty();
	}
}
