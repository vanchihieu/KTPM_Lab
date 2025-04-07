from flask import Flask, render_template, request, redirect
import redis

app = Flask(__name__)
r = redis.Redis(host='redis', port=6379)

@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        vote = request.form['vote']
        r.rpush('votes', vote)
        return redirect('/')
    return '''
    <h1>Vote!</h1>
    <form method="post">
        <button name="vote" value="Cats">Cats</button>
        <button name="vote" value="Dogs">Dogs</button>
    </form>
    '''
