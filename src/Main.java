import Prog1Tools.IOTools;

public class Main {

    public static void main(String[] args) {
        BTree<String> listS = new BTree<>();
        BTree<Integer> listI = new BTree<>();

        System.out.println("------------------------------------------");
        char type = 's';
        do {
            type = Character.toLowerCase(IOTools.readChar("data type of binary tree [s]string or [i]nt? "));
        } while(type != 's' && type != 'i');

        System.out.println("--------------------- Binary tree was created ----------------------");
        char cmd;
        do {
            cmd = Character.toLowerCase(IOTools.readChar(
                    "[i]nsert [p]rint [q]uit : "));
            switch (cmd) {
                // insert
                case 'i':
                    if(type == 's') {
                        listS.insert(IOTools.readString("Insert: "));
                    } else {
                        listI.insert(IOTools.readInt("Insert: "));
                    } break;
                // print
                case 'p':
                    Traversal traversal = Traversal.INORDER;
                    char tmp;
                    do {
                        tmp = Character.toLowerCase(IOTools.readChar("[P]REORDER, [I]NORDER, P[O]STORDER : "));
                    } while(tmp != 'p' && tmp != 'i' && tmp != 'o');
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
                    }
                    if(type == 's') {
                        listS.setTraversal(traversal);
                        System.out.println(listS);
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