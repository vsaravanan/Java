for %%* in (.) do set CurrDirName=%%~n*
echo %CurrDirName%
pause


SET src=Struts2ResourceBundle
SET dest=%CurrDirName%
rmdir /Q /S .settings build WebContent\WEB-INF\lib
del /Q /F .classpath .project

md .settings
xcopy  /s /d /Y /i "..\%src%\.settings" .settings

xcopy ..\%src%\.classpath . 
xcopy ..\%src%\.project .
xcopy ..\%src%\.gitignore .
xcopy ..\%src%\readme.md .

fnr --cl --dir "E:\GitPrj\Java\Struts2\%dest%" --fileMask "*.*"  --excludeFileMask "rpl.bat"  --includeSubDirectories --skipBinaryFileDetection --find "%src%" --replace "%dest%"
fnr --cl --dir "E:\GitPrj\Java\Struts2\%dest%" --fileMask "web.xml" --includeSubDirectories --find "    <filter-class>org.apache.struts2.dispatcher.FilterDispatcher</filter-class>" --replace "    <!-- <filter-class>org.apache.struts2.dispatcher.FilterDispatcher</filter-class>  -->\n    <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class> "
pause