package pl.pal.kamil.pt1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DiskFile extends DiskElement{



    protected void print(int depth) throws IOException {

        String output = "";

        for (int i = 0; i<depth; i++)
        {
            output += "-";
        }
        output += file.getName() + "  ";
        output += "P ";
        output += getSizeString(file.length());
        output += "\t\t";


        this.creationDate = new Date(Files.readAttributes(file.toPath(), BasicFileAttributes.class).creationTime().toMillis());
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = format.format(creationDate);

        output += formattedDate;

        System.out.println(output);


    }

    public DiskFile(File file)
    {
        super(file);
    }



}
