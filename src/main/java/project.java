

import java.nio.charset.Charset;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

class Project {
    // Bloom filter object
    static BloomFilter<String> emailList
            = BloomFilter.create(
            Funnels.stringFunnel(
                    Charset.forName("UTF-8")),
            10000);

    // create data set for email list
    public static void addEmail(){
        emailList.put("pooja.dhotre@gmail.com");
        emailList.put("pooja-dhotre@gmail.com");
        emailList.put("pooja_dhotre@gmail.com");
        emailList.put("arti_dhotre@gmail.com");
        emailList.put("arti_dhotre@gmail.com");
        emailList.put("priyanka_more@gmail.com");
        emailList.put("priyanka-more@gmail.com");
        emailList.put("priyanka.dhotre@gmail.com");
        emailList.put("pooja_dhotre@outlook.com");
        emailList.put("pooja-dhotre@outlook.com");
        emailList.put("pooja.dhotre@live.com");

    }
    public static void checkBloomFilter(String checkData){
        // Test the bloom filter
        String str = emailList.mightContain(checkData) ? "exist" : "not exist";
        System.out.println("The email "+checkData+" does "+str+ " in the list");
    }
    public static void main(String[] args)
    {
        // Add email in bloom filter data set
        addEmail();

        // check bloom filter
        checkBloomFilter("pooja.dhotre@gmail.com");

        // check bloom filter
        checkBloomFilter("arti.dhotre@gmail.com");
    }
}
