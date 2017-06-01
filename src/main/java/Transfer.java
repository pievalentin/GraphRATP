/**
 * Created by Pierre Valentin on 30/05/2017.
 */
public class Transfer {
    protected int idStation1;
    protected int idStation2;

    public int getIdStation1() {
        return idStation1;
    }

    public void setIdStation1(int idSation1) {
        this.idStation1 = idSation1;
    }

    public int getIdStation2() {
        return idStation2;
    }

    public void setIdStation2(int idStation2) {
        this.idStation2 = idStation2;
    }

    public Transfer(int idSation1, int idStation2) {
        this.idStation1 = idSation1;
        this.idStation2 = idStation2;
    }
}
