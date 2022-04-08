package pl.pal.kamil.pt1;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public abstract class DiskElement implements Comparable<DiskElement>{

protected File file;

protected long size;

protected Date creationDate;


    protected abstract void print (int depth) throws IOException;


public void print () throws IOException { print(0); }

public DiskElement (File file) {
    this.file = file;
    this.size = file.length();
};

protected String getSizeString (long b){
        if (b < 1024)
        {
            return b + "B";
        }
        if (b < 1024*1024)
        {
            long kb = b/1024;
            return kb + "KB";
        }
        if (b < 1024*1024*1024)
        {
            long mb = b/(1024*1024);
            return mb + "MB";
        }
        if (b < 1024*1024*1024*1024)
        {
            long gb = b/(1024^3);
            return gb + "GB";
        }

        return "0";

    }

    @Override
    public int compareTo(DiskElement o) {
        int wynik = file.compareTo(o.file);
        return wynik;
    }

    @Override
    public boolean equals(Object other) {

        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        DiskElement elem = (DiskElement) other;

        if (file != elem.file) {
            return false;
        }
        if (size != elem.size) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        return 113*Objects.hash(file,size,creationDate);
    }


    public long getSize() {return  size;}
    public File getFile() {return  file;}
    public Date getDate() {return  creationDate;}
    public void setSize(long size) {this.size = size;}
    public void setFile(File file) {this.file = file;}
    public void setDate(Date date) {this.creationDate = date;}
}


