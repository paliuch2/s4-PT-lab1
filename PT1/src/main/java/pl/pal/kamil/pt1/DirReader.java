package pl.pal.kamil.pt1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.TreeSet;

public class DirReader {

    public DirReader() {}
    public DiskElement Reading(Path path, int mode) throws IOException {

        File file = path.toFile();
        DiskElement element;
        if (file.isFile()) {element = new DiskFile(file);}
        else {element = new DiskDirectory(file);}

        if (element instanceof DiskDirectory)
        {
            switch(mode)
            {
                case 0: default: ((DiskDirectory) element).setChildren(new HashSet<DiskElement>()); break;
                case 1: ((DiskDirectory) element).setChildren(new TreeSet<DiskElement>()); break;
                case 2: ((DiskDirectory) element).setChildren(new TreeSet<>(new DiskComparator())); break;
            }
            if (file.listFiles() != null)
            {
                for (File f : file.listFiles())
                {
                    ((DiskDirectory) element).adding(Reading(f.toPath(),mode));

                }
                long size = ((DiskDirectory) element).countSize();
                element.setSize(size);


            }

        }


            return element;
    }
}
