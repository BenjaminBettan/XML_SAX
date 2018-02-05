# XML_SAX

Able to parse huge xml files by creating serialized entities for each tag detected by SAX API.

You can update the entry file as well.

Entry file for example :
<!-->
<?xml version="1.0" encoding="UTF-8" ?>
<r0 id="a" ttt="b">
	<r1 z="c" y="d">
		<r1_1>aa</r1_1>
		<r1_2>bb</r1_2>
		<r1_3>cc</r1_3>
		<r1_4 x="e" w="f">
			<r1_4_1>aaa</r1_4_1>
		</r1_4>
	</r1>
	
</r0>
<--!>

just edit executeScenario method in the class below, it's an example, it should show how to use it


package m;

public class SubMain extends SubMain_A{

	public void run(String[] args) {
	
		init(args);
		
		executeScenario();
		
	}

	private void executeScenario() {
	
		logger.info("Let's run a scenario !");
		
		for (long i = 0; i < NB_INSTANCE; i++) 
		{
			logger.info( x.getEntity(i));
		}
		
		logger.info( "Print XML : " + x.showXml() );
		
		logger.info("Show me value 5 in xml : "+ x.getEntity(5).showXmlValue());
		
	}
}



Should work on linux and windows, it should print :

Start init;

XMLFILE to load : inputXmlFile.xml;

Clear database (serialized xml entities) -> delete directory ressources\database then create it again;

About to parse;

The XML file has been parsed by SAX. 7 instances to parse;

End of init;

Let's run a scenario !;

XMLEntity [id=0, level=0, tag=r0, data=, leaf=false, isChildOf=-1, attributes={y=d, z=c}, isFatherOf=[1]];

XMLEntity [id=1, level=1, tag=r1, data=, leaf=false, isChildOf=0, attributes={w=f, x=e}, isFatherOf=[2, 3, 4, 5]];

XMLEntity [id=2, level=2, tag=r1_1, data=aa, leaf=true, isChildOf=1, attributes={}, isFatherOf=null];

XMLEntity [id=3, level=2, tag=r1_2, data=bb, leaf=true, isChildOf=1, attributes={}, isFatherOf=null];

XMLEntity [id=4, level=2, tag=r1_3, data=cc, leaf=true, isChildOf=1, attributes={}, isFatherOf=null];

XMLEntity [id=5, level=2, tag=r1_4, data=, leaf=false, isChildOf=1, attributes={}, isFatherOf=[6]];

XMLEntity [id=6, level=3, tag=r1_4_1, data=aaa, leaf=true, isChildOf=5, attributes={}, isFatherOf=null];

Print XML : <?xml version="1.0" encoding="UTF-8" ?><r0 ttt="b" id="a"><r1 y="d" z="c"><r1_1>aa</r1_1><r1_2>bb</r1_2><r1_3>cc</r1_3><r1_4 w="f" x="e"><r1_4_1>aaa</r1_4_1></r1_4></r1></r0>;

Show me value 5 in xml : <r1_4 w="f" x="e"><r1_4_1>aaa</r1_4_1></r1_4>;
