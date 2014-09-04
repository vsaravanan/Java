<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

  <head>
  <sx:head/>
  </head>
  
  <body>

<pre>

	javascript:
	
	   function enableTab(param) {
	      var tabContainer = dojo.widget.byId('tabContainer7');
	      tabContainer.enableTab(param);
	   }
	    
	   
	   function disableTab(param) {
	      var tabContainer = dojo.widget.byId('tabContainer7');
	      tabContainer.disableTab(param);
	   }

</pre>     
 

<script type="text/javascript">
   function enableTab(param) {
      var tabContainer = dojo.widget.byId('tabContainer7');
      tabContainer.enableTab(param);
   }
    
   
   function disableTab(param) {
      var tabContainer = dojo.widget.byId('tabContainer7');
      tabContainer.disableTab(param);
   }
</script>

<sx:tabbedpanel  id="tabContainer7">
   <sx:div id="tab1" label="Tab 1">
       Local Tab 1
   </sx:div>   
   <sx:div id="tab2" label="Tab 2" disabled="true">
       Local Tab 2
   </sx:div>   
</sx:tabbedpanel>

<!-- By Tab Index -->
<input type="button" onclick="enableTab(1)" value="Enable Tab 2 using Index" />
<input type="button" onclick="disableTab(1)" value="Disable Tab 2 using Index" />
    
<!-- By Tab Id -->
<input type="button" onclick="enableTab('tab2')" value="Enable Tab 2 using Id" />
<input type="button" onclick="disableTab('tab2')" value="Disable Tab 2 using Id" />   


<pre>

	Fixed size (size does not adjust to current tab) 
	cssStyle="width: 500px; height: 100px;" doLayout="true"
</pre>
<sx:tabbedpanel cssStyle="width: 500px; height: 100px;" doLayout="true" id="tabContainer2">
   <sx:div label="Tab 1" >
       Local Tab 1
   </sx:div>   
   <sx:div label="Tab 2" >
       Local Tab 2
   </sx:div>   
</sx:tabbedpanel>

<pre>

	Do not load tab 2 when page loads (it will be loaded when selected) 
	preload="false"
</pre>
<sx:tabbedpanel id="tabContainer3">
   <sx:div label="Remote Tab 1" href="%{#url}">
       Remote Tab 1
   </sx:div>  
   <sx:div label="Remote Tab 2" href="%{#url}" preload="false">
       Remote Tab 2
   </sx:div>      
</sx:tabbedpanel>

<pre>

	Reload tabs content when selected 
	refreshOnShow="true"
</pre>
<sx:tabbedpanel id="tabContainer4">
   <sx:div label="Remote Tab 1" href="%{#url}" refreshOnShow="true">
       Remote Tab 1
   </sx:div>  
   <sx:div label="Remote Tab 2" href="%{#url}" refreshOnShow="true">
       Remote Tab 2
   </sx:div>      
</sx:tabbedpanel>

<pre>

	Tab2 : disabled="true"
</pre>
<sx:tabbedpanel id="tabContainer5">
   <sx:div label="Tab 1" >
       Local Tab 1
   </sx:div>   
   <sx:div label="Tab 2" disabled="true">
       Local Tab 2
   </sx:div>   
</sx:tabbedpanel>

<pre>

	labelposition="bottom" 
</pre>
<sx:tabbedpanel labelposition="bottom" id="tabContainer6">
   <sx:div label="Tab 1" >
       Local Tab 1
   </sx:div>   
   <sx:div label="Tab 2" >
       Local Tab 2
   </sx:div>   
</sx:tabbedpanel>


<pre>

	closable="true"
</pre>
<sx:tabbedpanel id="tabContainer8">
   <sx:div label="Tab 1" >
       Local Tab 1
   </sx:div>   
   <sx:div label="Tab 2"  closable="true">
       Local Tab 2
   </sx:div>   
</sx:tabbedpanel>

<script type="text/javascript">
   dojo.event.topic.subscribe('/before', function(event, tab, tabContainer) {
      alert("Before selecting tab");
   });

   dojo.event.topic.subscribe('/after', function(tab, tabContainer) {
      alert("After tab was selected");
   });
</script>
<pre>
Publish topics when tab is selected:

   dojo.event.topic.subscribe('/before', function(event, tab, tabContainer) {
      alert("Before selecting tab");
   });

   dojo.event.topic.subscribe('/after', function(tab, tabContainer) {
      alert("After tab was selected");
   });
   
	beforeSelectTabNotifyTopics="/before" afterSelectTabNotifyTopics="/after"
</pre>
<sx:tabbedpanel beforeSelectTabNotifyTopics="/before" afterSelectTabNotifyTopics="/after" id="tabContainer9">
   <sx:div label="Tab 1">
       Local Tab 1
   </sx:div>   
   <sx:div label="Tab 2">
       Local Tab 2
   </sx:div>   
</sx:tabbedpanel>

<script type="text/javascript">
   dojo.event.topic.subscribe('/before2', function(event, tab, tabContainer) {
      event.cancel = tab.widgetId == "tab2" ;
   });
</script>
<pre>
Prevent tab 2 from being selected :

   dojo.event.topic.subscribe('/before2', function(event, tab, tabContainer) {
      event.cancel = tab.widgetId == "tab2" ;
   });

	beforeSelectTabNotifyTopics="/before2"

</pre>

<sx:tabbedpanel beforeSelectTabNotifyTopics="/before2" id="tabContainer10">
   <sx:div id="tab1" label="Tab 1">
       Local Tab 1
   </sx:div>   
   <sx:div id="tab2" label="Tab 2">
       Local Tab 2
   </sx:div>   
   <sx:div id="tab3" label="Tab 3">
       Local Tab 3
   </sx:div>     
</sx:tabbedpanel>

<pre>
Customize template css path (Dojo widget template css) :

	templateCssPath="%{#cssUrl}" 

</pre>
<sx:tabbedpanel templateCssPath="%{#cssUrl}" id="tabContainer11">
   <sx:div id="tab1" label="Tab 1">
       Local Tab 1
   </sx:div>   
   <sx:div id="tab2" label="Tab 2">
       Local Tab 2
   </sx:div>   
</sx:tabbedpanel>

<pre>
Select tab using JavaScript :

   function selectTab(id) {
     var tabContainer = dojo.widget.byId("tabContainer12");
     tabContainer.selectTab(id);
   }
   
   onclick="selectTab('tab1')" 

</pre>

<script type="text/javascript">
   function selectTab(id) {
     var tabContainer = dojo.widget.byId("tabContainer12");
     tabContainer.selectTab(id);
   }
</script>
<sx:tabbedpanel id="tabContainer12">
   <sx:div label="Tab 1" id="tab1">
       Local Tab 1
   </sx:div>   
   <sx:div label="Tab 2" id="tab2">
       Local Tab 2
   </sx:div>   
</sx:tabbedpanel>

<input type="button" onclick="selectTab('tab1')" value="Select tab 1" />
<input type="button" onclick="selectTab('tab2')" value="Select tab 2" />

  </body>
