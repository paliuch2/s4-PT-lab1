package pl.pal.kamil.pt1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class DiskDirectory extends DiskElement {

   private Set<DiskElement> children;



    protected void print(int depth) throws IOException {

      //  System.out.println(children.size());
        String output = "";
;
        for (int i=0; i<depth;i++)
        {
            output += "-";
        }
        output += file.getName() + " K ";


        output += getSizeString(size);

        output += "\t\t";
        long modTime = file.lastModified();

        this.creationDate = new Date(Files.readAttributes(file.toPath(), BasicFileAttributes.class).creationTime().toMillis());
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = format.format(creationDate);

        output += formattedDate;
        System.out.println(output);
        for (DiskElement d : children)
        {
            d.print(depth+1);
        }

    }

    public DiskDirectory(File file)
    {
        super(file);
    }

    public void setChildren(Set<DiskElement> c) {
        this.children = c;
    };

    public void adding(DiskElement e)
    {
        children.add(e);
    }

    public long countSize() {
        long sz = 0;
        for (DiskElement d : children)
        {
            if (d instanceof DiskDirectory) {
                sz += ((DiskDirectory) d).countSize();
            }
            else
                sz += d.size;
        }

        return sz;
    }


}
