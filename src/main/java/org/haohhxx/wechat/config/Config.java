package org.haohhxx.wechat.config;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.haohhxx.wechat.entity.SearchResult;
import org.haohhxx.wechat.lucene.LuceneSearcher;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by hao on 16-10-23.
 *
 */
public class Config {

//    public final static String PROXY_path = "/home/hao/PycharmProjects/ipproxy/data/";
//
//    public final static String disk_message_path = "/home/hao/文档/j2ee_workspace/diskSearcher/data/user_share/";

//    public final static String indexpath = ".\\index";
//    public final static String indexpath = Config.class.getResource("/index/").getFile();
//    public final static URL url = Config.class.getClassLoader().getResource("./index/");
//    public final static String indexpath = new File(url.getFile()).getPath();
    public static String indexpath = "/home/hao/index/";
    public static void main(String[] args) {
        ArrayList<SearchResult>  re = new ArrayList<>();
        try {
//            System.out.println(indexpath);
//            System.out.println(new File(indexpath).getPath());
            int top=100;
            String field = "content";
            Analyzer analyzer = new StandardAnalyzer();

            Path p = Paths.get(new File(indexpath).getPath());
            Directory dir = FSDirectory.open(p);

            IndexReader reader = DirectoryReader.open(dir);
            LuceneSearcher searcher = new LuceneSearcher(reader,field,analyzer);
            re = searcher.luceneSearch_nolight("天使",top);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(SearchResult searchResult:re){
            System.out.println(searchResult.getNameString());
        }
    }

}
