# @(#)Makefile.win32	15.1 03/03/06 12:11:22
#
# Copyright (c) 2002 Sun Microsystems, Inc. All Rights Reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are met:
#
# -Redistributions of source code must retain the above copyright notice, this
# list of conditions and the following disclaimer.
#
# -Redistribution in binary form must reproduce the above copyright notice,
# this list of conditions and the following disclaimer in the documentation
# and/or other materials provided with the distribution.
#
# Neither the name of Sun Microsystems, Inc. or the names of contributors may
# be used to endorse or promote products derived from this software without
# specific prior written permission.
#
# This software is provided "AS IS," without a warranty of any kind. ALL
# EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING ANY
# IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR
# NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE
# LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
# OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS
# LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
# INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
# CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF
# OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN ADVISED OF THE
# POSSIBILITY OF SUCH DAMAGES.
#
# You acknowledge that Software is not designed,licensed or intended for use in
# the design, construction, operation or maintenance of any nuclear facility.
#

JARPATH=..\lib\jai_core.jar;..\lib\jai_codec.jar;..\lib\mlibwrapper_jai.jar

SRCS1 = \
	JAIDemo.java \
	JAIDemoPanel.java \
	JAIAddConstPanel.java \
	JAIBlurSharpPanel.java \
	JAIConvolvePanel.java \
	JAIGradientPanel.java \
	JAIMedianPanel.java \
	JAIPatternPanel.java \
	JAIRotatePanel.java \
	JAISamplePanel.java \
	JAIScalePanel.java \
	JAITransposePanel.java \
	JAIDyadicPanel.java \
	JAIDyadicAddPanel.java \
	JAIDyadicDividePanel.java \
	JAIDyadicMultiplyPanel.java \
	JAIDyadicSubtractPanel.java \
	JAIDyadicSource0Panel.java \
	JAIDyadicSource1Panel.java \
	JAISourceAdjPanel.java\
	JAIOpPanel.java \
	JAIImageReader.java \
	SampleDescriptor.java \
	IconJAI.java

SRCS2 = \
	SampleDescriptor.java \
	JAIImageReader.java \
	ImageCanvas.java \
	JAIExampleApp.java

SRCS3 = \
	JAIFileBrowser.java \
	JAIImageReader.java \
	IconJAI.java

SRCS4 = \
	JAIWarpDemo.java


all:	JAIDemo JAIExampleApp JAIFileBrowser JAIWarpDemo

JAIDemo: 
	javac -classpath $(JARPATH);. $(SRCS1)

JAIExampleApp: 
	javac -classpath $(JARPATH);. $(SRCS2)

JAIFileBrowser: 
	javac -classpath $(JARPATH);. $(SRCS3)

JAIWarpDemo: 
	javac -classpath $(JARPATH);. $(SRCS4)

clean:
	del /F *.class 
