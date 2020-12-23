import kotlin.Metadata;
import kotlin.io.ConsoleKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   mv = {1, 4, 1},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"},
   d2 = {"main", "", "Problems-The_sequence_1_2_2_3_3_3"}
)
public final class MainKt {
   public static final void main() {
      String var10000 = ConsoleKt.readLine();
      Intrinsics.checkNotNull(var10000);
      String solution = var10000;
      boolean var2 = false;
      int n = Integer.parseInt(solution);
      solution = "";
      int solutionCount = 0;

      for(int i = 1; i <= n && solutionCount < n; ++i) {
         for(int j = 1; j <= i && solutionCount < n; ++j) {
            ++solutionCount;
            solution = solution + i + ' ';
         }
      }

      boolean var5 = false;
      if (solution == null) {
         throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      } else {
         String var7 = StringsKt.trim((CharSequence)solution).toString();
         var5 = false;
         System.out.println(var7);
      }
   }

   // $FF: synthetic method
   public static void main(String[] var0) {
      main();
   }
}
