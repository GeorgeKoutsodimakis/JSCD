package jscd.treegen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class ReadFile {

Treegen treegen = new Treegen();
File dir = new File("c:/users/georgios/workspace/jscd/src");
//System.out.println("Getting all files in " + dir.getCanonicalPath() + " including those in subdirectories");
String syntaxTree;
public String reading(File dir) throws FileNotFoundException{
	List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
	for (File file : files) {
    //treegen.trees(file);
    syntaxTree = treegen.trees(file);
}
	return syntaxTree;



}
}
