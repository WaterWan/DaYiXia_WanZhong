package water.eluosifangkuai.config;

import java.lang.Integer;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * 游戏配置器
 * 
 */
public class GameConfig {

	/*
	 * 窗口宽度
	 */
	private int width;
	
	/*
	 * 窗口高度
	 */
	private int height;
	
	/*
	 * 标题
	 */
	private String title;
	
	/*
	 * 窗口拔高
	 */
	private int windowUp;
	
	/*
	 * 边框尺寸
	 */
	private int windowSize;
	
	/*
	 * 边框内边距
	 */
	private int padding;
	
	/*
	 * 图层属性
	 */
	private List<LayerConfig> layersConfig;
	/*
	 * 构造函数
	 * 读取XML文件，获取全部游戏配置
	 * 
	 * 
	 */
	
	public GameConfig() throws Exception{
		//创建XML读取器
		SAXReader reader=new SAXReader();
		//读取XML文件
		Document doc=reader.read("config/cfg.xml");
		//获取XML文件的根节点
		Element game=doc.getRootElement();
		//配置窗口参数
		this.SetUiConfig(game.element("frame"));
		//配置系统参数
		this.setSystemConfig(game.element("system"));
		//配置数据访问参数
		this.setDataConfig(game.element("data"));		
	}
	
	
	/*
	 * 配置窗口
	 * 
	 * @param frame 配置文件的窗口配置元素
	 */
	private void SetUiConfig(Element frame){
		//获取窗口宽度
		this.width=Integer.parseInt(frame.attributeValue("width"));
		//获取窗口高度
		this.height=Integer.parseInt(frame.attributeValue("height"));
		//获取边框粗细
		this.windowSize=Integer.parseInt(frame.attributeValue("windowSize"));
		//获取边框内边距
		this.padding=Integer.parseInt(frame.attributeValue("padding"));
		//获取标题
		this.title=frame.attributeValue("title");
		//获取窗口拔高
		this.windowUp=Integer.parseInt(frame.attributeValue("windowUp"));
		//获取窗体属性
		List<Element> layers=frame.elements("layer");
		layersConfig=new ArrayList<LayerConfig>();
		//获取所有窗体属性
		for(Element layer : layers){
			LayerConfig lc=new LayerConfig(
				layer.attributeValue("className"),
				Integer.parseInt(layer.attributeValue("x")),
				Integer.parseInt(layer.attributeValue("y")),
				Integer.parseInt(layer.attributeValue("w")),
				Integer.parseInt(layer.attributeValue("h"))
			);

			layersConfig.add(lc);
		}
	}
	
	
	/*
	 * 配置系统参数
	 * 
	 * @param frame
	 * 
	 */	
	private void setSystemConfig(Element frame){
		//TODO 配置系统参数
	}
	
	
	/*
	 * 
	 * 配置数据访问参数
	 * 
	 * @param data
	 */
	private void setDataConfig(Element frame){
		//TODO 配置数据访问参数
	}


	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}


	public int getWindowSize() {
		return windowSize;
	}


	public int getPadding() {
		return padding;
	}


	public List<LayerConfig> getLayersConfig() {
		return layersConfig;
	}
	
	public String getTitle(){
		return title;
	}
	
	public int getWindowUp(){
		return windowUp;
	}
	
}
