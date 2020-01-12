import Prog1Tools.IOTools;

public class Main {

    public static void main(String[] args) {
        BTree<String> listS = new BTree<>();
        BTree<Integer> listI = new BTree<>();
        BTree<Product> listP = new BTree<>();

        System.out.println("------------------------------------------------------");
        char type = 'i';
        do {
            type = Character.toLowerCase(IOTools.readChar("data type of binary tree [s]string [i]nt [p]roduct? "));
        } while(type != 's' && type != 'i' && type != 'p');

        System.out.println("-------------- Binary tree was created ---------------");
        char cmd;
        do {
            cmd = Character.toLowerCase(IOTools.readChar(
                    "[i]nsert [p]rint [s]ampleInsert [q]uit : "));
            switch (cmd) {
                // sample insert
                case 's':
                    if(type == 's') {
                        for (int i = 0; i < 10; i++) {
                            listS.insert(String.valueOf((char) (65 + Math.random()*26)));
                        }
                    } else if(type == 'p') {
                        for (int i = 0; i < 10; i++) {
                            listP.insert(new Product(String.valueOf((char)(65 + Math.random()*26)) , (int)(Math.random()*11)));
                        }
                    } else {
                        Integer[] addList = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
                        for (int i = 0; i < addList.length; i++) {
                            listI.insert(addList[i]);
                        }
                    } break;
                // insert
                case 'i':
                    if(type == 's') {
                        listS.insert(IOTools.readString("Insert: "));
                    } else if(type == 'p') {
                        listP.insert(new Product(IOTools.readString("name: "), IOTools.readInt("value: ")));
                    } else {
                        listI.insert(IOTools.readInt("Insert: "));
                    } break;
                // print
                case 'p':
                    Traversal traversal = Traversal.BREADTHFIRST;
                    char tmp = 't';
                    do {
                        tmp = Character.toLowerCase(IOTools.readChar("[P]REORDER, [I]NORDER, P[O]STORDER [T]REE : "));
                    } while(tmp != 'p' && tmp != 'i' && tmp != 'o' && tmp != 't');
                    switch(tmp) {
                        case 'p':
                            traversal = Traversal.PREORDER;
                            break;
                        case 'i':
                            traversal = Traversal.INORDER;
                            break;
                        case 'o':
                            traversal = Traversal.POSTORDER;
                            break;
                        case 't':
                            traversal = Traversal.BREADTHFIRST;
                            break;
                    }
                    if(type == 's') {
                        listS.setTraversal(traversal);
                        System.out.println(listS);
                    } else if(type == 'p') {
                        listP.setTraversal(traversal);
                        System.out.println(listP);
                    } else {
                        listI.setTraversal(traversal);
                        System.out.println(listI);
                    } break;
                // quit
                case 'q':
                    System.out.println("Good bye!");
                    break;
                // invalid input
                default:
                    System.out.println("Invalid input! Try again ...");
            }
        } while(cmd != 'q');
    }
}