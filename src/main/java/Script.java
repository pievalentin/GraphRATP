import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Pierre Valentin on 30/05/2017.
 */
public class Script {
    final static Charset ENCODING = StandardCharsets.UTF_8;

    public static List<Node> readNode(String aFileName) throws IOException {
        List<Node> list = new ArrayList<>();
        Path path = Paths.get(aFileName);
        try (Scanner scanner =  new Scanner(path, ENCODING.name())){
            scanner.nextLine();
            while (scanner.hasNextLine()){
                final String nextLine = scanner.nextLine();
                String[] strings = nextLine.split(",");
                String[] strings2 = nextLine.split("\"");
                //strings[0] the id of the stop
                // strings2[1] name of the stop
                //strings[4] print Latitude
                //strings[5] longitude
                list.add(new Node(Integer.parseInt(strings[0]),Double.parseDouble(strings[4]),Double.parseDouble(strings[5]),strings2[1]));

            }
        }
        return list;


    }
    static List<TempTransfer> buildTempTransfert(String aFileName) throws IOException {
        List<TempTransfer> list = new ArrayList<>();
        Path path = Paths.get(aFileName);
        try (Scanner scanner =  new Scanner(path, ENCODING.name())){
            scanner.nextLine();
            while (scanner.hasNextLine()){
                final String nextLine = scanner.nextLine();
                String[] strings = nextLine.split(",");
                //strings[0] strings[1] are the id we keep from text file
                list.add(new TempTransfer(Integer.parseInt(strings[0]),Integer.parseInt(strings[1])));

            }
            return list;
        }

    }
    @SuppressWarnings("Duplicates")
    public static List<Transfer> buildTransferList (String filePath) throws IOException {
        List<Transfer> resultList = new ArrayList<>();
        List<TempTransfer> tempList = buildTempTransfert(filePath);
        for (TempTransfer x:tempList
             ) {
            int id1 = x.getIdStation1();
            int id2 = x.getIdStation2();
            int idStation1 = 0; // les deux id que l'on va garder
            int idStation2 = 0;

           /* if (id1 > 10000){ // Si id1 est l'id du trajet
                int i = 0;
                for (TempTransfer y:tempList
                     ) {
                    if (y.getIdStation1()== id1){
                        if (i==0){
                            idStation1 = y.getIdStation2();
                            i++;
                        }
                        else{
                            idStation2 = y.getIdStation2();
                        }
                    }
                    if(y.getIdStation2() == id1){
                        if(i==0){
                            idStation1 = y.getIdStation1();
                            i++;
                        }
                        else{
                            idStation2 = y.getIdStation1();
                        }
                    }
                }
            }
            else if (id2 > 10000){ // Si id2 est l'id du trajet
                int i = 0;
                for (TempTransfer y:tempList
                        ) {
                    if (y.getIdStation1()== id2){
                        if (i==0){
                            idStation1 = y.getIdStation2();
                            i++;
                        }
                        else{
                            idStation2 = y.getIdStation2();
                        }
                    }
                    if(y.getIdStation2() == id2){
                        if(i==0){
                            idStation1 = y.getIdStation1();
                            i++;
                        }
                        else{
                            idStation2 = y.getIdStation1();
                        }
                    }
                }
            }*/
            //resultList.add(new Transfer(idStation1, idStation2));
            resultList.add(new Transfer(id1,id2));
        }//c'est là l'erreur
        return resultList;
        }
    }

