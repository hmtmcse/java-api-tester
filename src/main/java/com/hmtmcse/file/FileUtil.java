package com.hmtmcse.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<FileInfo> listAll(String location) throws FileExceptionHandler {
        return list(location, true, true, true);
    }


    public static List<FileInfo> listAllFile(String location)throws FileExceptionHandler {
        return list(location, false, true, true);
    }

    public static List<FileInfo> listAllDirectory(String location)throws FileExceptionHandler {
        return list(location, true, false, true);
    }

    public static List<FileInfo> listFiles(String location)throws FileExceptionHandler {
        return list(location, false, true, false);
    }

    public static List<FileInfo> listDirectories(String location)throws FileExceptionHandler {
        return list(location, true, false, false);
    }


    private static List<FileInfo> list(String location, Boolean includeDir, Boolean includeFile, Boolean isRecursive) throws FileExceptionHandler {
        File file = new File(location);
        FileInfo fileInfo;
        List<FileInfo> subDirectories = new ArrayList<>();
        if (!file.exists()){
            throw new FileExceptionHandler("Invalid Location");
        }
        List<FileInfo> fileInfoList = new ArrayList<>();
        for (File fileLData : file.listFiles() ) {
            if (fileLData.isFile() && includeFile){
                fileInfoList.add(getFileInfo(fileLData));
            }else if (fileLData.isDirectory()){
                fileInfo = getFileInfo(fileLData);
                if (isRecursive){
                    subDirectories = list(fileLData.getAbsolutePath(), includeDir, includeFile, isRecursive);
                }
                if (subDirectories.size() == 0 && includeDir){
                    fileInfoList.add(fileInfo);
                }else if (subDirectories.size() != 0){
                    fileInfo.setSubDirectories(subDirectories);
                    fileInfoList.add(fileInfo);
                }
            }
        }
        return fileInfoList;
    }

    public static void print(List<FileInfo> list){
        print(list, "-");
    }


    private static void print(List<FileInfo> list, String space){
        String line = "";
        for (FileInfo fileInfo: list){
            line = space + "Name:" + fileInfo.getName();
            if (fileInfo.isDirectory){
                System.out.println(line + " Type: Directory");
                if (fileInfo.subDirectories.size() != 0){
                    print(fileInfo.subDirectories, space + "-");
                }
            }else{
                System.out.println(line + " Type: File. Extension: " + fileInfo.getFileExtension());
            }
        }
    }

    private static FileInfo getFileInfo(File file){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setName(file.getName());
        fileInfo.setDirectory(file.isDirectory());
        fileInfo.setAbsolutePath(file.getAbsolutePath());
        if (file.isFile()){
            fileInfo.setFile(file.isFile());
            fileInfo.setFileExtension(getFileExtension(file.getName()));
        }

        fileInfo.setLastModified(file.lastModified());
        return fileInfo;
    }

    public static String getFileExtension(String fileName) {
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
            return fileName.substring(fileName.lastIndexOf(".")+1);
        }else{
            return "";
        }
    }

}
