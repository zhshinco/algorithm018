public class UglyNumber {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> s = new HashSet<>();

        long[] primes = new long[]{2, 3, 5};
        for (long prime : primes) {
            pq.offer(prime);
            s.add(prime);
        }
        long num = 1;
        for (int i = 1; i < n; i++) {
            num = pq.poll();
            if(i == n - 1)
                return (int)num;

            //遍历三个因子
            for (int j = 0; j < 3; j++) {
                if (!s.contains(num * primes[j])) {
                    pq.offer(num * primes[j]);
                    s.add(num * primes[j]);
                }
            }
        }
        return (int) num;
    }
}