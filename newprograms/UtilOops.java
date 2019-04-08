//package newprograms;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.List;
//import java.util.Scanner;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class UtilOops {
//
//	public static File getFile(String path) {
//		File file = new File(path);
//		return file;
//	}
//
//	static Scanner sc = new Scanner(System.in);// Scanner class declaration
//
//	public static int readInteger() {
//		return sc.nextInt();
//	}
//
//	public static double readdouble() {
//		return sc.nextDouble();
//	}
//
//	@SuppressWarnings("resource")
//	public static String readString() {
//		Scanner sc = new Scanner(System.in);
//		String result = sc.nextLine();
//		return result;
//	}
//
//	public static boolean readBoolean() {
//		return sc.nextBoolean();
//	}
//
//	public static long readlong() {
//		return sc.nextLong();
//	}
//
//	public static String readJsonFile(String path) {
//		String line = "";
//		String jsonData = "";
//		try {
//			FileReader fr = new FileReader(path);
//			BufferedReader br = new BufferedReader(fr);
//			while ((line = br.readLine()) != null) {
//				jsonData += line;
//			}
//			br.close();
//
//		} catch (FileNotFoundException e) {
//			exceptions ex = exceptions.FileNotFoundException;
//			System.out.println(ex + e.getMessage());
//		} catch (IOException e) {
//			exceptions ex = exceptions.IOException;
//			System.out.println(ex + e.getMessage());
//		}
//
//		return jsonData;
//	}
//
//	enum exceptions {
//		FileNotFoundException, IOException, JsonParseException, JsonMappingException, JsonGenerationException;
//
//	}
//
//	public static String readJsonFile(File path) {
//
//		String line = "";
//		String jsonData = null;
//		try {
//			FileReader fr = new FileReader(path);
//			BufferedReader br = new BufferedReader(fr);
//			while ((line = br.readLine()) != null) {
//				jsonData += line;
//			}
//			br.close();
//
//		} catch (FileNotFoundException e) {
//			exceptions ex = exceptions.FileNotFoundException;
//			System.out.println(ex + e.getMessage());
//		} catch (IOException e) {
//			exceptions ex = exceptions.IOException;
//			System.out.println(ex + e.getMessage());
//		}
//
//		return jsonData;
//
//	}
//
//	public static ObjectMapper mapper;
//	static {
//		mapper = new ObjectMapper();
//	}
//
//	public static String convertJavaToJson(Object object) {
//		String jsonResult = "";
//		try {
//			jsonResult = mapper.writeValueAsString(object);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return jsonResult;
//	}
//
//	public static <T> T convertJsonToJava(String jsonString, Class<T> cls) {
//		T result = null;
//		try {
//			result = mapper.readValue(jsonString, cls);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return result;
//	}
//
//	
//
//	
//
//}