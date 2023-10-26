import java.util.Queue;

public class client extends Thread {
    private LRU_PageReplacement lru;
    private Fifo_PageReplacement fifo;
    private  SecondChance_Replacement secondChance;

    public client(int line) {
        lru = new LRU_PageReplacement(line);
        fifo = new Fifo_PageReplacement(line);
        secondChance = new SecondChance_Replacement(line);
    }


    @Override
    public void run() {
        loop:
        while (true) {
            int customer_id = ClientAPI.send_data();
            switch (customer_id) {
                case 0:
                    System.out.printf("LRU:<%d>,FIFO:<%d>,Second-chance:<%d>%n", lru.getPage_faults(),
                            fifo.getPage_faults(), secondChance.getPage_faults());
                    break loop;
                default:
                    System.out.println(customer_id);
                    System.out.printf("LRU:<%s>\nFIFO:<%s>\nSecond-chance:<%s>%n", lru.add_page(customer_id),
                            fifo.add_page(customer_id), secondChance.add_page(customer_id));
                    break;

            }
        }
    }
}
