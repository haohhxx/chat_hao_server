package config;

import entity.SearchResult;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import search.LuceneSearcher;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by hao on 16-10-23.
 *
 */
public class config {

    public final static String PROXY_path = "/home/hao/PycharmProjects/ipproxy/data/";

    public final static String disk_message_path = "/home/hao/文档/j2ee_workspace/diskSearcher/data/user_share/";

    public final static String indexpath = "./web/data/index";

    public static void main(String[] args) {
        ArrayList<SearchResult>  re = new ArrayList<>();
        try {
            System.out.println(new File(indexpath).getPath());
            int top=100;
            String field = "content";
            Analyzer analyzer = new StandardAnalyzer();

            Path p = Paths.get(indexpath);
            Directory dir = FSDirectory.open(p);

            IndexReader reader = DirectoryReader.open(dir);
            LuceneSearcher searcher = new LuceneSearcher(reader,field,analyzer);
            re = searcher.luceneSearch_nolight("天使",top);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(re);
    }

}
