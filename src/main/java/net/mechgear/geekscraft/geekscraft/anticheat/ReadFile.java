package net.mechgear.geekscraft.geekscraft.anticheat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.mechgear.geekscraft.geekscraft.Window.Prompt;

public class ReadFile {
	
	//声明用于保存文件列表的List对象
	private List<File> fileList= new ArrayList<File>();
	
	ReadFile(){
		//初始化
		readFile();
	}
	
	//获取.minecraft的绝对路径
	private String getPath(){
		//获取一个假设文件的路径以做参照
		String test = new String(new File("Test.txt").getAbsolutePath());
		test = test.substring(0, test.length()-9);
		//判断路径是否正确，并对路径做修改（针对不同启动器）
		//检查路径中是否含有.minecraft,若不包含，则test.lastIndexOf(".minecraft")返回值为-1
		if (test.lastIndexOf(".minecraft")== -1){
			//如果路径中不包含.minecraft
			//则手动在路径后增加一个"/.minecraft"
			test+="/.minecraft";
			//确认路径是否正确
			if(new File(test+"/versions").isDirectory()){
				return test;
			}else{
				System.out.println("Cannot find the game Directory");
				new Prompt("Cannot find the game Directory,当前root路径："+test);
				System.out.println("当前root路径:"+test);
				return null;
			}
		}else{
			//如果路径中包含
			//判断路径是否正确
			if(new File(test+"/versions").isDirectory()){
				return test;
			}else{
				System.out.println("Cannot find the game Directory");
				new Prompt("Cannot find the game Directory,当前root路径："+test);
				System.out.println("当前root路径:"+test);
				return null;
			}
		}
		
	}
	//负责写入的fileList的方法
	private void readFile(){
		String root = getPath();
		fileReader(root+"/mods", fileList);
		fileReader(root+"/versions", fileList);
		fileReader(root+"/libraries", fileList);
		fileList.add(new File(root+"/launcher_profiles.json"));
		
	}
	
	//获取fileList的方法
	List<File> getFileList(){
		return fileList;
	}
	
	
	//文件列表读取通用方法，dir参数为文件索引路径，list参数为索引File对象保存于的List
	private void fileReader(String dir,List<File> list){
		//读取dir目录下的文件，生成File数组
	 	File[] files = new File(dir).listFiles();
	 	//将files中的内容写入list
		for(File i:files){
			//判断是否为文件夹
			if(i.isDirectory()){
				//递归
				fileReader(i.getAbsolutePath(),list);
				
			}else{
				//否则写入list
				list.add(i);
			}
		}
	}
	
}
