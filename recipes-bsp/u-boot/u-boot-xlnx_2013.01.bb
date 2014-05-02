
# We use the revision in order to avoid having to fetch it from the
# repo during parse
# Corresponds to github.com/Xilinx tag V14.5
SRCREV = "20a6cdd301941b97961c9c5425b5fbb771321aac"
PV = "v2013.01${XILINX_EXTENSION}"
PR = "r1"

ZYNQ_FSBL = "${WORKDIR}/fsbl-${MACHINE}.elf"
ZYNQ_UENV = "${WORKDIR}/uEnv-${MACHINE}.txt"
ZYNQ_BITFILE = "${WORKDIR}/${MACHINE}.bit"

include u-boot-xlnx.inc

SRC_URI_append += " \
		file://microblaze_bootm_Add_support_for_loading_initrd.patch \
		file://microblaze_bootm_Fix_coding_style_issues.patch \
		file://microblaze_Fix_coding_style_for_bootb.patch \
		file://zynq_common-Add-uEnv.txt-boot-environment-load-suppo.patch \
		file://zynq-Increase-number-of-arguments.patch \
	  file://${MACHINE}/fsbl-${MACHINE}.elf.bz2 \
    file://${MACHINE}/uEnv-${MACHINE}.txt.bz2 \
    file://${MACHINE}/${MACHINE}.bit.bz2 \
    "
