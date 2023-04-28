package util;

import java.io.*;


public class FileUtility {
    public static void writeIntoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, false);
    }

    public static void appendIntoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, true);
    }

    private static void writeIntoFile(String fileName, String text, boolean append) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, append))) {
            bw.write(text);
        }
    }

    public static String readIntoFileWithString(String fileName) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String st;
            StringBuilder result = new StringBuilder(" ");
            while ((st = br.readLine()) != null) result.append(st);
            return result.toString();
        }
    }

    public static void writeBytes(String fileName, byte[] data) throws Exception {
        File file = new File(fileName);
        FileOutputStream outputStream = new FileOutputStream(file);

        outputStream.write(data);
        outputStream.flush();
        outputStream.close();

        System.out.print("File is created successfully with the content.");
    }

    public static byte[] readIntoFileWithBytes(String fileName) throws Exception {
        File file = new File(fileName);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytesArray = new byte[(int) file.length()];
            fis.read(bytesArray);
            return bytesArray;
        }
    }

    public static void writeObjectToFile(Serializable obj, String fileName) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(obj);
        }
    }

    public static Serializable readObjectToFile(String fileName) throws Exception {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // read object from file
            Serializable obj = (Serializable) ois.readObject();
            return obj;
        }
    }


}

