require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

XILINX_EXTENSION = "-xilinx"

FILESEXTRAPATHS += "${THISDIR}/u-boot-xlnx:${THISDIR}/u-boot-xlnx/${MACHINE}"
SRC_URI = " \
		git://github.com/Xilinx/u-boot-xlnx.git;protocol=git \
		"
do_bootbin() {
	if command -v bootgen > /dev/null 2>&1 && [ -e ${ZYNQ_FSBL} ] ; then
		rm -f ${S}/BOOT.BIN
		echo "the_ROM_image:" > bootimage.bif
		echo "{" >> bootimage.bif
		echo " [bootloader]${ZYNQ_FSBL}" >> bootimage.bif
		if [ -e ${ZYNQ_BITFILE} ] ; then
			echo " ${ZYNQ_BITFILE}" >> bootimage.bif
		fi
		echo " [load = 0x04000000, startup = 0x04000000]${S}/${UBOOT_BINARY}" >> bootimage.bif
		echo "}" >> bootimage.bif
		bootgen -image bootimage.bif -o i ${S}/BOOT.BIN
	fi
	if [ -e ${ZYNQ_UENV} ] ; then
		rm -f ${S}/uEnv.txt
		cp ${ZYNQ_UENV} ${S}/uEnv.txt
	fi
}

include u-boot-extra.inc

addtask bootbin before do_deploy do_install after do_compile

