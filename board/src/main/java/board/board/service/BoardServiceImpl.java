package board.board.service;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.board.dto.BoardDto;
import board.board.mapper.BoardMapper;
import board.common.FileUitls;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private FileUitls fileUtils;
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}
	
	@Override
	public void insertBoard(BoardDto board) throws Exception {
		
		
//		if(ObjectUtils.isEmpty(multipartHttpServletRequest) == false) {
//			Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
//			String name;
//			while(iterator.hasNext()) {
//				name = iterator.next();
//				log.debug("file tag name :"+name );
//				List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
//				for(MultipartFile multipartFile : list) {
//					log.debug("start file information");
//					log.debug("file name : "+ multipartFile.getOriginalFilename());
//					log.debug("file size : "+ multipartFile.getSize());
//					log.debug("file content type : "+ multipartFile.getContentType());
//					log.debug("end file information.\n");
//				}
//			}
//		}
		
		boardMapper.insertBoard(board);
		
//		List<BoardFileDto> list = fileUtils.parseFileInfo(board.getBoardIdx(), multipartHttpServletRequest);
//		if(CollectionUtils.is) {
//			boardMapper.insertBoard(list);
//		}
	}

	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception{
		BoardDto board = boardMapper.selectBoardDetail(boardIdx);
		boardMapper.updateHitCount(boardIdx);
		return board;
	}
	
	@Override
	public void updateBoard(BoardDto board) throws Exception {
		boardMapper.updateBoard(board);
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardMapper.deleteBoard(boardIdx);
	}
}	

