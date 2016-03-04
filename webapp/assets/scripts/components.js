/**
 * Created by NargiT on 28/02/2016
 */
var React = require('react');
var ReactDOM = require('react-dom');
var $ = require('jquery');

var CommentBox = React.createClass({
  loadCommentsFromServer : function() {
    $.ajax({
      url: this.props.url,
      dataType: 'json',
      cache: false,
      success: function (data) {
        this.setState({data: data});
      }.bind(this),
      error: function (xhr, status, err) {
        console.error(this.props.url, status, "Problem"+err.toString());
      }.bind(this)
    });
  },
  getInitialState: function () {
    return {data: []};
  },
  componentDidMount : function() {
    this.loadCommentsFromServer();
    //setInterval(this.loadCommentsFromServer, this.props.pollInterval);
  },
  render: function () {
    return (
      <div className="commentBox">
        <h1>Comments</h1>
        <CommentList data={this.state.data}/>
        <CommentForm />
      </div>
    );
  }
});

var CommentForm = React.createClass({
  render: function () {
    return (
      <div className="commentForm">
        Hello, world! I am a CommentForm.
      </div>
    );
  }
});

var Comment = React.createClass({
  render: function () {
    return (
      <div className="comment">
        <h2 className="commentAuthor">
          {this.props.author}
        </h2>
        {this.props.children}
      </div>
    )
  }
});

var CommentList = React.createClass({
  render: function () {
    var commentNodes = this.props.data.map(function (comment) {
      return (
        <Comment author={comment.author} key={comment.id}>
          {comment.text}
        </Comment>
      );
    });
    return (
      <div className="commentList">
        {commentNodes}
      </div>
    );
  }
});

var aLimit=Math.floor((Math.random() * 10) + 1);
var aUrl = "/ranking-service/api/v1/comments?limit="+aLimit;
ReactDOM.render(
  <CommentBox url={aUrl} />,
  document.getElementById('content')
);