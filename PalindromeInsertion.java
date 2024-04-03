public class PalindromeInsertion {
    public static void main(String[] args) {
        String x = "2001";
        int insertions = palindromeInsertion(x);
        String palindrome = constructPalindrome(x);

        System.out.println("最小插入数： " + insertions);
        System.out.println("回文序列： " + palindrome);
    }

    public static int palindromeInsertion(String x) {
        int n = x.length();
        int[][] dp = new int[n][n];// dp[i][j]表示将x[i...j]变成回文序列的最小插入数
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (x.charAt(i) == x.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }

    public static String constructPalindrome(String x) {
        int n = x.length();
        int[][] dp = new int[n][n];
        StringBuilder[][] palindrome = new StringBuilder[n][n];

        for (int i = 0; i < n; i++) {
            palindrome[i][i] = new StringBuilder().append(x.charAt(i));
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                char start = x.charAt(i);
                char end = x.charAt(j);
                if (start == end) {
                    dp[i][j] = dp[i + 1][j - 1];
                    palindrome[i][j] = new StringBuilder().
                            append(start).
                            append(palindrome[i + 1][j - 1]).
                            append(end);
                } else {
                    if (dp[i + 1][j] < dp[i][j - 1]) {
                        dp[i][j] = dp[i + 1][j] + 1;
                        palindrome[i][j] = new StringBuilder().
                                append(start).
                                append(palindrome[i + 1][j]).
                                append(start);
                    } else {
                        dp[i][j] = dp[i][j - 1] + 1;
                        palindrome[i][j] = new StringBuilder().
                                append(end).
                                append(palindrome[i][j - 1]).
                                append(end);
                    }
                }
            }
        }
        return palindrome[0][n - 1].toString();
    }
}