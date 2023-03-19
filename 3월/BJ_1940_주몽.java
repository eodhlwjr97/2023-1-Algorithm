import java.io.*;
import java.util.*;

// 3월 19일에 다시 풀어보기 (풀이참고)
public class BJ_1940_주몽{


    public static boolean[] material_list=new boolean[200001];

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int material_num=scan.nextInt();
        int material_need=scan.nextInt();

        int sum=0;
        
        if(material_need>200000){
            System.out.println("0");
            scan.close();
            return;
        }

        for(int i=0;i<material_num;i++){
            int temp=scan.nextInt();
            material_list[temp]=true;
        }

        for(int i=1;i<=200000;i++)
        {
            if(material_list[i] && material_need>i){
                if(material_list[material_need-i])
                    sum++;
            }

        }

        System.out.println(sum/2);

        scan.close();
    }


}
