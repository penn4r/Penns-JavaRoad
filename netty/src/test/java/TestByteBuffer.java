import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestByteBuffer {
    public static void main(String[] args) {
        try(FileChannel channel = new FileInputStream("./netty/data.txt").getChannel()){
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while(true){
                int len = channel.read(buffer);
                if(len==-1) break;
                buffer.flip();
                while(buffer.hasRemaining()){
                    char b = (char) buffer.get();
                    System.out.print(b+" ");
                }
                buffer.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
