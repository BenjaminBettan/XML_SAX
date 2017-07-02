# XML_SAX
Parse huge xml files


Should work on linux and windows, it should print :

2017-07-02_20:48:15|INFO |                        main> Start init;

2017-07-02_20:48:15|INFO |                        main> XMLFILE to load : inputXmlFile.xml;

2017-07-02_20:48:15|INFO |                        main> Clear database (serialized xml entities) -> delete directory ressources\database then create it again;

2017-07-02_20:48:15|INFO |                        main> About to parse;

2017-07-02_20:48:15|INFO |                        main> The XML file has been parsed by SAX. 7 instances to parse;

2017-07-02_20:48:15|INFO |                        main> End of init;

2017-07-02_20:48:15|INFO |                        main> Let's run a scenario !;

2017-07-02_20:48:15|INFO |                        main> XMLEntity [id=0, level=0, tag=r0, data=, leaf=false, isChildOf=-1, attributes={y=d, z=c}, isFatherOf=[1]];

2017-07-02_20:48:15|INFO |                        main> XMLEntity [id=1, level=1, tag=r1, data=, leaf=false, isChildOf=0, attributes={w=f, x=e}, isFatherOf=[2, 3, 4, 5]];

2017-07-02_20:48:15|INFO |                        main> XMLEntity [id=2, level=2, tag=r1_1, data=aa, leaf=true, isChildOf=1, attributes={}, isFatherOf=null];

2017-07-02_20:48:15|INFO |                        main> XMLEntity [id=3, level=2, tag=r1_2, data=bb, leaf=true, isChildOf=1, attributes={}, isFatherOf=null];

2017-07-02_20:48:15|INFO |                        main> XMLEntity [id=4, level=2, tag=r1_3, data=cc, leaf=true, isChildOf=1, attributes={}, isFatherOf=null];

2017-07-02_20:48:15|INFO |                        main> XMLEntity [id=5, level=2, tag=r1_4, data=, leaf=false, isChildOf=1, attributes={}, isFatherOf=[6]];

2017-07-02_20:48:15|INFO |                        main> XMLEntity [id=6, level=3, tag=r1_4_1, data=aaa, leaf=true, isChildOf=5, attributes={}, isFatherOf=null];

2017-07-02_20:48:15|INFO |                        main> Print XML : <?xml version="1.0" encoding="UTF-8" ?><r0 ttt="b" id="a"><r1 y="d" z="c"><r1_1>aa</r1_1><r1_2>bb</r1_2><r1_3>cc</r1_3><r1_4 w="f" x="e"><r1_4_1>aaa</r1_4_1></r1_4></r1></r0>;

2017-07-02_20:48:15|INFO |                        main> Show me value 5 in xml : <r1_4 w="f" x="e"><r1_4_1>aaa</r1_4_1></r1_4>;

2017-07-02_20:48:15|INFO |                        main> End of program;
